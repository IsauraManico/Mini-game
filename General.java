
import java.awt.Image;



/**
 *
 * @author isaura
 */
public class General 
{
    private int posx,posy,altura,largura;
    private int velx = 3;
    private int vely = 3;
    
    private int pontuation = 0 ;
    
    private int vidaInicial = 3;
    private int jogoVidas = vidaInicial ;
    
    private Image foto;
    private Image ball;
    
    public General(int posx, int posy, int largura, int altura)      
    {
        this.posx = posx;
        this.posy = posy;
        this.largura = largura;
        this.altura = altura;
    }

    public int getPosx()
    {
        return posx;
    }

    public void setPosx(int posx)
    {
        this.posx = posx;
    }

    public int getPosy() 
    {
        return posy;
    }

    public void setPosy(int posy) 
    {
        this.posy = posy;
    }

    public int getAltura() 
    {
        return altura;
    }

    public void setAltura(int altura)
    {
        this.altura = altura;
    }

    public int getLargura()
    {
        return largura;
    }

    public void setLargura(int largura)
    {
        this.largura = largura;
    }

    public int getVelx()
    {
        return velx;
    }

    public void setVelx(int velx)
    {
        this.velx = velx;
    }

    public int getVely() 
    {
        return vely;
    }

    public void setVely(int vely)
    {
        this.vely = vely;
    }
    
    public void update()
    {
        this.posx = posx + velx;
        
        this.posy = posy + vely;
              
    }

    public Image getFoto() 
    {
        return foto;
    }

    public void setFoto(Image foto)
    {
        this.foto = foto;
    }

    public int getJogoVidas() 
    {
        return jogoVidas;
    }

    public void setJogoVidas(int jogoVidas) 
    {
        this.jogoVidas = jogoVidas;
    }

    public int getVidaInicial() 
    {
        return vidaInicial;
    }

    public void setVidaInicial(int vidaInicial) 
    {
        this.vidaInicial = vidaInicial;
    }

    public int getPontuation()
    {
        return pontuation;
    }

    public void setPontuation(int pontuation) 
    {
        this.pontuation = pontuation;
    }

    public Image getBall() 
    {
        return ball;
    }

    public void setBall(Image ball)
    {
        this.ball = ball;
    }
    
 
    
    
}
