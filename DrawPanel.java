
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



/**
 * Totalmente Orientado a Objecto
 * @author isaura
 */
public class DrawPanel extends JPanel implements ActionListener
{
    
    
   Timer tempo ;
    
   
    General bola = new General(300,350,50,50);
    
    General atacante = new General(10,200,40,120);
    
    
    
    EntradaTeclado tecla = new EntradaTeclado();
    
       
    
    
    public DrawPanel()
    {
       
        JFrame frame = new JFrame();
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(900,700);
        
        frame.setTitle("Primeiro JOGO");
        //frame.setResizable(false);
        
        
        frame.add(this);
        
        this.setBackground(Color.gray);
        //this.setBackground(Color.red);
        frame.addKeyListener(tecla);
        
       // bola.setFoto(new ImageIcon(getClass().getResource("img/imagem.jpg")).getImage());
        
        frame.setVisible(true);
        
        tempo = new Timer(10,this);
        tempo.start();
    
    }
    
    public void paintComponent( Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D)g;
        
        g.setColor(Color.red);
        Ellipse2D.Double oval = new Ellipse2D.Double(bola.getPosx(),bola.getPosy(),bola.getLargura(),bola.getAltura()); 
        g2d.fill(oval);
        
        
       
        g.setColor(Color.black);
        g.drawString("Vida:"+atacante.getJogoVidas()+""+"Pontuation:"+atacante.getPontuation(),700,30);
        
        
        g2d.setColor(Color.pink);
        Rectangle2D.Double reta = new Rectangle2D.Double(atacante.getPosx(),atacante.getPosy(),atacante.getLargura(),atacante.getAltura());
        g2d.fill(reta);
        
        //g2d.drawImage(atacante.getFoto(), atacante.getPosx(),atacante.getPosy(),atacante.getLargura(),atacante.getAltura(),this);
        
        
    }
    
    public void atualizar()
    {
        
          
        
                if(bola.getPosx() >= getWidth()- bola.getLargura()) //condicao para nao sair da largura da tela a direira
                {
                    bola.setVelx(bola.getVelx()*(-1));
                }
                else if( bola.getPosx() <= 0 ) //Quando a bola estrapola o tamanho da largura do jogador, 
                {
                    bola.setVelx(bola.getVelx()*(-1));//voltando na origem
                    
                    
                    atacante.setJogoVidas ( atacante.getJogoVidas()-1 ); //diminui a vida do jogador quando nao consegue defender
                    
                    
                    if( atacante.getJogoVidas() == 0 )
                    {
                        int resposta = JOptionPane.showConfirmDialog (null,"Voce perdeu! Deseja  Continuar e jogar Novamente?");
                        
                        if( resposta == JOptionPane.OK_OPTION )
                        {
                            atacante.setJogoVidas( atacante.getVidaInicial() );
                            
                            atacante.setPontuation(0);
                        }
                        else
                        {
                            System.exit(1);
                        }
                    }
                }
                  bola.setPosx( bola.getPosx() + bola.getVelx() ); //adiciona a velocidade na posicao x

                if( bola.getPosy() >= getHeight()- bola.getAltura() || (bola.getPosy() <= 0) )
                {
                    bola.setVely( bola.getVely()* (-1) );
                                  
                }
              
              
                 bola.setPosy(bola.getPosy()+bola.getVely());
                
                 //verificando a colisao em x                              //falta condicao
                if(( atacante.getPosx()+atacante.getLargura()) >= bola.getPosx() ) //verificando o length da largura
                {
                    if(bola.getPosy() >= atacante.getPosy() && bola.getPosy()<= atacante.getPosy()+atacante.getAltura())
                    {
                        bola.setVelx(bola.getVelx()*(-1));
                         
                        
                        atacante.setPontuation(atacante.getPontuation()+1);
                        
                        atacante.setJogoVidas(atacante.getJogoVidas()+1);
                        
                        if(atacante.getPontuation() == 100)
                        {
                            JOptionPane.showMessageDialog(null,atacante.getPontuation()+" Pontos :Parabens, voce ganhouu!");
                        }

                         
  
                       
                    }
                   
                }
                
                
                
               
                
                //verificando a colisao em yy
                
                 
                //Condicoes para escutar o teclado
                
      
                if(tecla.isCima() || atacante.getPosy()>=getHeight()-atacante.getAltura()) 
                {
                    atacante.setPosy(atacante.getPosy()-atacante.getVely());
                }
                
                 if(tecla.isBaixo() || atacante.getPosy()<=0)
                {
                    atacante.setPosy(atacante.getPosy()+atacante.getVely());
                }
    
      
     
        
    }
    


    @Override
    public void actionPerformed(ActionEvent e) 
    {
          atualizar();
            repaint();
    }
    
}

