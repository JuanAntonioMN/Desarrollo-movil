package com.example.gesturesmasmultitouch;

import android.view.MotionEvent;
import android.view.View;

public class RotationGestureDetector {
    private static final int INVALID_POINTER_ID = -1;

    private float fX, fY, sX, sY;
    private int ptrID1, ptrID2;
    private float mAngle;
    private View mView;

    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationDetector);

        boolean onRotationBegin(RotationGestureDetector rotationDetector);

        void onRotationEnd(RotationGestureDetector rotationDetector);
    }

    private OnRotationGestureListener mListener;

    public RotationGestureDetector(OnRotationGestureListener listener) {
        mListener = listener;
        ptrID1 = INVALID_POINTER_ID;
        ptrID2 = INVALID_POINTER_ID;
    }

    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                ptrID1 = event.getPointerId(event.getActionIndex());
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                ptrID2 = event.getPointerId(event.getActionIndex());
                sX = event.getX(event.findPointerIndex(ptrID1));
                sY = event.getY(event.findPointerIndex(ptrID1));
                fX = event.getX(event.findPointerIndex(ptrID2));
                fY = event.getY(event.findPointerIndex(ptrID2));
                if (mListener != null) {
                    mListener.onRotationBegin(this);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (ptrID1 != INVALID_POINTER_ID && ptrID2 != INVALID_POINTER_ID) {
                    float nfX, nfY, nsX, nsY;
                    nsX = event.getX(event.findPointerIndex(ptrID1));
                    nsY = event.getY(event.findPointerIndex(ptrID1));
                    nfX = event.getX(event.findPointerIndex(ptrID2));
                    nfY = event.getY(event.findPointerIndex(ptrID2));
                    mAngle = angleBetweenLines(fX, fY, sX, sY, nfX, nfY, nsX, nsY);
                    if (mListener != null) {
                        mListener.onRotation(this);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                ptrID1 = INVALID_POINTER_ID;
                if (mListener != null) {
                    mListener.onRotationEnd(this);
                }
                break;
            case MotionEvent.ACTION_POINTER_UP:
                ptrID2 = INVALID_POINTER_ID;
                if (mListener != null) {
                    mListener.onRotationEnd(this);
                }
                break;
        }
        return true;
    }

    private static float angleBetweenLines(float fX, float fY, float sX, float sY, float nfX, float nfY, float nsX, float nsY) {
        float angle1 = (float) Math.atan2(fY - sY, fX - sX);
        float angle2 = (float) Math.atan2(nfY - nsY, nfX - nsX);
        float angle = ((float) Math.toDegrees(angle1 - angle2)) % 360;
        if (angle < -180.0f) angle += 360.0f;
        if (angle > 180.0f) angle -= 360.0f;
        return -angle;
    }

    public float getAngleDelta() {
        return mAngle;
    }
}
