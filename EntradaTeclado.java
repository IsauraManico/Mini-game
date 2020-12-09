
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Responsavel por implementar os metodos do KeyListener

/**
 *
 * @author isaura
 */
public class EntradaTeclado implements KeyListener
{
    private boolean cima;
    private boolean baixo;
   
    
    
    public EntradaTeclado()
    {
        this.cima = false;
        this.baixo = false;
           
        
    }

   
    public boolean isCima() {
        return cima;
    }

    public void setCima(boolean cima) {
        this.cima = cima;
    }

    public boolean isBaixo()
    {
        return baixo;
    }

    public void setBaixo(boolean baixo)
    {
        this.baixo = baixo;
    }
    
    

    @Override
    public void keyTyped(KeyEvent ke)
    {
       // System.out.println(""+ke.getKeyCode());
       
    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        //System.out.println(""+ke.getKeyCode());
        
        if(ke.getKeyCode() == KeyEvent.VK_UP)
        {
            cima = true;
        }
         if(ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
           baixo = true;
        }
         
        
        
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {
       // System.out.println(""+ke.getKeyCode());
        
         if(ke.getKeyCode() == KeyEvent.VK_UP)
        {
            cima = false;
        }
         if(ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
           baixo = false;
        }
         
       
       
    }
    
}
