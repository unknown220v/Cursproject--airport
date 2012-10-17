package Modelrgr;

import process.Actor;
import process.Dispatcher;
import process.IWaitCondition;
import queues.QueueForTransactions;
import rnd.Randomable;


public class Patient extends Actor {
    public QueueForTransactions queueToCashier;
    public QueueForTransactions queueToStewardess;
    public int max;
    public double finishTime;
    public Dispatcher disp;
    public Randomable rnd;
    
    public Patient(String name,ModelGui gui,Model model){
        setNameForProtocol(name);
        queueToCashier = model.getQueueToCashier();
        queueToStewardess = model.getQueueToStewardess();
        max = gui.getMaxClients();
        disp = model.dispatcher;
        finishTime = gui.getChooseDataModel().getDouble();
        rnd =  gui.getChooseRandomPass();
    }

    @Override
    protected void rule() {
       // throw new UnsupportedOperationException("Not supported yet.");
        while(true){
                        
            if (disp.getCurrentTime() > finishTime){
                break;
            }
            double xx = rnd.next();
            holdForTime(xx);
            
            if (queueToCashier.size() >= max){
                if (queueToStewardess.size() >= max){
                    continue;
                }
                queueToStewardess.addLast(new Object());
                continue;
            }
            queueToCashier.addLast(new Object());
            
            
        }
    }
    
}