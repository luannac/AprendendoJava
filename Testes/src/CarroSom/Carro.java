package CarroSom;

import java.io.File;

import javax.swing.JOptionPane;

public class Carro {
	private boolean booLigado;
	private byte bytVelocidade;
	private String strCor,strPlaca;
	private short shoAno;
	
	//Construtor
	public Carro(String strCor, String strPlaca, short shoAno) {
		super();
		this.strCor = strCor;
		this.strPlaca = strPlaca;
		this.shoAno = shoAno;
	}
	
	//Metodos
	public void acelerar(byte ac) {
		if(isBooLigado()) {
			if(getBytVelocidade()<120) {
				setBytVelocidade((byte)(getBytVelocidade()+ac));
			Music track = new Music(new File("src/CarroEustaquio/acelerando.wav")); 
			Play play = new Play(track);
			Thread newThrd = new Thread(play);
			newThrd.start();
			}else
				JOptionPane.showMessageDialog(null, "Carro n�o aguenta mais");
			
		}else
			JOptionPane.showMessageDialog(null,"Carro est� desligado");
	}
	public void frear(byte ac) {
		if(isBooLigado()) {
			if(getBytVelocidade()>0) 
				setBytVelocidade((byte)(getBytVelocidade()-ac));
			else 
				JOptionPane.showMessageDialog(null, "O Carro est� parado");
		}else
			JOptionPane.showMessageDialog(null, "O Carro est� desligado");
		
	}
	public void ligar() {
		if(isBooLigado()) {
			JOptionPane.showMessageDialog(null, "Carro j� est� ligado");
		}else {
			setBooLigado(true);
			Music track = new Music(new File("src/CarroEustaquio/Carro Ligando.wav")); 
			Play play = new Play(track);
			Thread newThrd = new Thread(play);
			newThrd.start();
		}
	}
	public void desligar() {
		if(isBooLigado()) {
			if(getBytVelocidade()>0)
				JOptionPane.showMessageDialog(null, "Carro em movimento n�o pode desligar.");
			else
				setBooLigado(false);
		}else
			JOptionPane.showMessageDialog(null, "Carro j� est� desligado");
	}
	public String status() {
		if(isBooLigado())
			return "src\\CarroEustaquio\\imagens\\onOff.jpg";
		else
			return "src\\CarroEustaquio\\imagens\\off.jpg";
	}
	
	//Getters e Setters

	public boolean isBooLigado() {
		return booLigado;
	}
	private void setBooLigado(boolean booLigado) {
		this.booLigado = booLigado;
	}
	public byte getBytVelocidade() {
		return bytVelocidade;
	}
	private void setBytVelocidade(byte bytVelocidade) {
		this.bytVelocidade = bytVelocidade;
	}
	public String getStrCor() {
		return strCor;
	}
	public void setStrCor(String strCor) {
		this.strCor = strCor;
	}
	public String getStrPlaca() {
		return strPlaca;
	}
	public void setStrPlaca(String strPlaca) {
		this.strPlaca = strPlaca;
	}
	public short getShoAno() {
		return shoAno;
	}
	public void setShoAno(short shoAno) {
		this.shoAno = shoAno;
	}
}
