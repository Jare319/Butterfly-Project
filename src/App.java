public class App {
    public static void main(String[] args) throws Exception {
        CustomFrame f = new CustomFrame();
        
        while(true) {
            f.canvas.repaint();
            Thread.sleep(10);
        }
    }
}
