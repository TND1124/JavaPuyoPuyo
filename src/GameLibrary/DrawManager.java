package GameLibrary;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/** 画像描画管理 */
public class DrawManager 
{
    /**描画に必要な情報 */
    public class DrawData
    {
        private Image image;
        private int x;
        private int y;
        private int width;
        private int height;

        public Image getImage() { return image; }
        public int getX() { return x; }
        public int getY() { return y; }
        public int getWidth() { return width; }
        public int getHeight() { return height; }

        public DrawData(Image image, int x, int y, int width, int height)
        {
            this.image = image;
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    /** 画像識別用ID */
    public enum GraphicsId
    {
        PuyoGreen,
        PuyoBlue,
        PuyoRed,
        PuyoYellow,
        Cross,
        Frame
    }

    private static DrawManager instance = null;
    /** 生成した画像情報を入れるディクショナリ */
    private Map<GraphicsId, Image> imageDic = new HashMap<GraphicsId, Image>();
    /** ゲームに表示する画像情報を入れる配列 */
    private ArrayList<DrawData> drawList = new ArrayList<>();

    private DrawManager()
    {
        // 使用したい画像を登録
        imageDic.put(GraphicsId.PuyoGreen, Toolkit.getDefaultToolkit().getImage("img\\PuyoGreen.png"));
        imageDic.put(GraphicsId.PuyoBlue, Toolkit.getDefaultToolkit().getImage("img\\PuyoBlue.png"));
        imageDic.put(GraphicsId.PuyoRed, Toolkit.getDefaultToolkit().getImage("img\\PuyoRed.png"));
        imageDic.put(GraphicsId.PuyoYellow, Toolkit.getDefaultToolkit().getImage("img\\PuyoYellow.png"));
        imageDic.put(GraphicsId.Cross, Toolkit.getDefaultToolkit().getImage("img\\cross.png"));
        imageDic.put(GraphicsId.Frame, Toolkit.getDefaultToolkit().getImage("img\\frame.png"));
    }

    public static DrawManager getInstance()
    {
        if(instance == null)
        {
            instance = new DrawManager();
        }
        return instance;
    }

    public ArrayList<DrawData> getDrawList()
    {
        return drawList;
    }

    public void clear()
    {
        drawList.clear();
    }

    /**
     *  画像を表示させる GameObjectのDraw関数で呼ぶ 
     */
    public void drawImage(GraphicsId id, int x, int y, int width, int height)
    {
        DrawData drawData = new DrawData(imageDic.get(id), x, y, width, height);
        drawList.add(drawData);
    }
}
