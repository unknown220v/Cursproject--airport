package Modelrgr;

import process.Actor;
import process.IWaitCondition;
import queues.QueueForTransactions;
import process.Dispatcher;
import process.DispatcherFinishException;

public class Cashier extends Actor{
    public QueueForTransactions  clients;
    public QueueForTransactions queuePass;
    public QueueForTransactions queueToPlain;
    public Dispatcher disp;
    public int maxClients;
    public double finishTime;
    public double activateTime;
    
    public Cashier(String name,ModelGui gui,Model model){
        setNameForProtocol(name);
        maxClients = gui.getChooseDataQueryPass().getInt();
        finishTime = gui.getChooseDataModel().getDouble();
        activateTime = gui.getChooseDataTimeCl().getDouble();
        
        clients = 	   model.getQueueToCashier();
        queuePass= model.getQueuePass();
        queueToPlain = model.getQueueToPlain();
        
        disp = model.dispatcher;
        
    }
    @Override
    protected void rule() {
//        throw new UnsupportedOperationException("Not supported yet.");
        
        IWaitCondition checkClients = new IWaitCondition() {

            @Override
            public boolean testCondition() {
                //throw new UnsupportedOperationException("Not supported yet.");
                return Cashier.this.isNull();
            }
            
            @Override
            public String toString(){
                return ("Пока нету покупателей");
            }
        };
        while(!false){

        	if (disp.getCurrentTime() > finishTime){
        		break;
            }
            try {
                waitForCondition(checkClients);
            } catch (DispatcherFinishException e) {
            	return;
            }

        	clients.removeFirst();
        	queueToPlain.addLast(new Object());
        	//queuePass.addLast(new Object());
            holdForTime( activateTime);
                
        }
    }
    
    public boolean isNull()
    {
    return this.clients.size() > 0;
    }
}
