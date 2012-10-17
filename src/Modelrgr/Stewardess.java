package Modelrgr;


import process.Actor;
import process.Dispatcher;
import process.DispatcherFinishException;
import process.IWaitCondition;
import queues.QueueForTransactions;
import rnd.Randomable;

public class Stewardess  extends Actor {
    public QueueForTransactions clients;
    public QueueForTransactions queuePlain;
    public QueueForTransactions queueToPlain;
    public QueueForTransactions queuePass;
    public double finishTime;
    public int maxClients;
    public double activateTime;
    public Dispatcher disp;
    Randomable rnd;
    
    public Stewardess(String name,ModelGui gui,Model model){
        setNameForProtocol(name);
        queuePlain = model.getQueuePlain();
        activateTime = gui.getChooseDataTimeCl().getDouble();
        maxClients = gui.getMaxClients();
        finishTime = gui.getChooseDataModel().getDouble();
        clients = model.getQueueToStewardess();
        queuePass = model.getQueuePass();
        queueToPlain = model.getQueueToPlain();
        rnd = gui.getChooseRandomSt();
        disp = model.dispatcher;
        
    }
    
    @Override
    protected void rule() {
//        throw new UnsupportedOperationException("Not supported yet.");
        
       // IWaitCondition checkPasagers= new IWaitCondition() {

   //         @Override
    //        public boolean testCondition() {
                //throw new UnsupportedOperationException("Not supported yet.");
    ////            return queueToPlain.size() > 0;
     //       }
            
            
      //      @Override
      //      public String toString(){
      //          return ("Пока нету обилеченных");
      //      }
            
     //   };
        
        IWaitCondition checkClients = new IWaitCondition() {

            @Override
            public boolean testCondition() {

                return clients.size() > 0;
            }
            
            @Override
            public String toString(){
                return ("Пока нету пациентов");
            }
            
        };
        
        for(;;){
            
            if (disp.getCurrentTime() > finishTime){
                break;
            }
            try{
                //throw new UnsupportedOperationException("Not supported yet.");
                // System.out.println("!?");
                // waitForCondition(checkPasagers);
                 holdForTime(rnd.next());//?
                // System.out.println("!");3
                 while(queueToPlain.size() > 0)
                 {
                 	queueToPlain.removeFirst();
                     queuePass.addLast(new Object());
                 }
                
            } catch (Exception e) {
                return;
            }
            

            try {
                waitForCondition(checkClients);
            } catch (DispatcherFinishException e) {
                return;
            }
            queueToPlain.addLast(clients.peekFirst());
            holdForTime(activateTime);
        }
    }
    
}