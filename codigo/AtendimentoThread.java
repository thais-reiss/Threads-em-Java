package codigo;

public class AtendimentoThread
        extends Thread {
 
  int idCliente;
 
  public AtendimentoThread(int idCliente) {
    this.idCliente = idCliente;
  }

  public void run() {
    System.out.println(
      getName() +
      " atendendo cliente " +
      idCliente);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
  }

  public static void main(String[] args) throws InterruptedException {
    int totalClientes = 5;
    AtendimentoThread[] atendimentos = new AtendimentoThread[5];

    long tempoInicial = System.currentTimeMillis();
    for(int i = 0; i < totalClientes; i++) {
        atendimentos[i] = new AtendimentoThread(i);
        atendimentos[i].setName("Atendimento-" + i);
        atendimentos[i].start();
    }

    for(AtendimentoThread atendimento : atendimentos) {
        atendimento.join();
    }
    long tempoFinal = System.currentTimeMillis();
    System.out.println("Tempo total de execução: " + (tempoFinal - tempoInicial) + " ms");
  
  }
}