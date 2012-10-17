package Modelrgr;

import process.Actor;
import process.Dispatcher;
import process.DispatcherFinishException;
import process.IWaitCondition;
import queues.QueueForTransactions;
import rnd.Randomable;

public class Plane extends Actor{
    public QueueForTransactions queuePass;
    public QueueForTransactions queuePlane;
    double finishTime;
    public Dispatcher disp;
    int placeSize;
    Randomable rnd;
    
    public Plane(String name,ModelGui gui,Model model){
        setNameForProtocol(name);
        queuePass = model.queuePass;
        queuePlane = model.getQueuePlain();
        finishTime = gui.getChooseDataModel().getDouble();
        placeSize = gui.getChooseDataPlCount().getInt();
        rnd = gui.getChooseRandomPlain();
        disp = model.dispatcher;
        
    }
    @Override
    protected void rule() {
//        throw new UnsupportedOperationException("Not supported yet.");
        
        IWaitCondition checkQueue = new IWaitCondition(){
            @Override
            public boolean testCondition() {
                //throw new UnsupportedOperationException("Not supported yet.");
                return queuePass.size()>= placeSize;
            }
            
            @Override
            public String toString(){
                return ("ѕока нету достаточного числа пациентов!");
            }
        };
        //queuePlane.add(this);
        while (true){
            if (disp.getCurrentTime() > finishTime){
                    break;
            }
            try {
            	//System.out.println("NYAAAAAAAAAAAAAAAAAAAAAAAAAAAAGH");
                waitForCondition(checkQueue);
            } catch (DispatcherFinishException e) {
                return;
            }
            for (int i =0; i<placeSize; i++){
                queuePass.removeFirst();
            }
            queuePlane.removeFirst();
            holdForTime(rnd.next());
            queuePlane.addLast(new Object());
        }
    }
    
}