/**
 * ぷよオブジェクト
 */
public class Puyo extends GameObject
{
    private float speed = 64.0f;
    private int width = 32;
    private int height = 32;
    private DrawManager drawManager = DrawManager.getInstance();
    /**
     * ぷよの色の種類
     */
    public enum Color
    {
        Green,
        Red,
        Blue,
        Yellow
    }

    private Color color;

    public Puyo(Color color)
    {
        objectType = ObjectType.Puyo;
        this.color = color;
    }

    public void update()
    {
        // 落下処理
        posY += 1;
    }

    /**
     * 画像の表示を行う
     */
    public void draw()
    {
        switch(color)
        {
            case Green:
                drawManager.drawImage(DrawManager.GraphicsId.PuyoGreen, (int)posX, (int)posY, width, height);
                break;
            case Red:
                drawManager.drawImage(DrawManager.GraphicsId.PuyoRed, (int)posX, (int)posY, width, height);
                break;
            case Blue:
                drawManager.drawImage(DrawManager.GraphicsId.PuyoBlue, (int)posX, (int)posY, width, height);
                break;
            case Yellow:
                drawManager.drawImage(DrawManager.GraphicsId.PuyoYellow, (int)posX, (int)posY, width, height);
                break;
        }
    }
}