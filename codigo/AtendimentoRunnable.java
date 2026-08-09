package codigo;

public class AtendimentoRunnable
        implements Runnable {
 
  int idCliente;
 
  public AtendimentoRunnable(int idCliente) {
    this.idCliente = idCliente;
  }

  public void run() {
    System.out.println(
      "atendendo cliente " +
      idCliente);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
  }

  public static void main(String[] args) throws InterruptedException {
    Runnable r = new AtendimentoRunnable(0);
    new Thread(r, "Atendente-1").start();
  }
}
 

