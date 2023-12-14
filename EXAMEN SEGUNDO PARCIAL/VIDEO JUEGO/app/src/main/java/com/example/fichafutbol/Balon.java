import android.graphics.Canvas;
import android.graphics.Paint;

public class Balon {
    private float x, y; // Posición de la pelota
    private float radio; // Radio de la pelota
    private float velocidadX, velocidadY; // Velocidad de la pelota

    public Balon(float x, float y, float radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
        velocidadX = 0; // Inicialmente, la pelota está quieta
        velocidadY = 0;
    }

    public void mover() {
        // Actualiza la posición de la pelota en función de la velocidad
        x += velocidadX;
        y += velocidadY;
    }

    public void dibujar(Canvas canvas, Paint paint) {
        // Dibuja la pelota en el lienzo con el centro en (x, y)
        canvas.drawCircle(x, y, radio, paint);
    }

    // Agrega métodos para establecer la velocidad u otras propiedades de la pelota según sea necesario.
}
