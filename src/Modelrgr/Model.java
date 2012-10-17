package Modelrgr;

import process.Dispatcher;
import queues.QueueForTransactions;
import queues.Store;
import qusystem.MultiActor;
import stat.DiscretHisto;

public class Model {
    public Dispatcher dispatcher;
    public ModelGui gui;
    public Patient patient;
    public Cashier cashier;
    public Stewardess stewardess;
    public Plane plane;
    public MultiActor planes;
    
    public QueueForTransactions queueToCashier;
    public QueueForTransactions queueToStewardess;
    public QueueForTransactions queueToPlain;
    public QueueForTransactions queuePlain;
    public QueueForTransactions queuePass;
    public DiscretHisto histoForQueueToCashier;
    public DiscretHisto histoForQueueToStewardess;
    public DiscretHisto histoForQueueToPlain;
    public DiscretHisto histoForQueuePlain;
    public DiscretHisto histoForQueuePass;  
    
    
    
    
    public Model(Dispatcher disp,ModelGui gui){
        if (disp == null || gui == null){
            System.out.println("Model init crash");
            System.exit(0);
        }
        queueToCashier = new  QueueForTransactions();
        queueToCashier.setNameForProtocol("Очередь к кассиру");
        queueToCashier.setDispatcher(disp);
        queueToStewardess  = new  QueueForTransactions();
        queueToStewardess.setNameForProtocol("Очередь к стюардессе");
        queueToStewardess.setDispatcher(disp);
        queueToPlain  = new  QueueForTransactions();
        queueToPlain.setNameForProtocol("Очередь к самолёту");
        queueToPlain.setDispatcher(disp);
        queuePlain  = new  QueueForTransactions();
        queuePlain.setNameForProtocol("Очередь самолётов");
        queuePlain.setDispatcher(disp);
        queuePlain.add(getPlane());
//        for (int i=0; i <  gui.getChooseDataPlCount().getInt();i++){
//        	queuePlain.addLast(new Object());
//        }
        queuePass  = new  QueueForTransactions();
        queuePass.setNameForProtocol("Очередь пассажиров");
        queuePass.setDispatcher(disp);
        this.dispatcher = disp;
        this.gui = gui;
        
        this.componentsToStartList();
    }
 
    public void componentsToStartList() {
        dispatcher.addStartingActor(getPatient());
        dispatcher.addStartingActor(getCashier());
        dispatcher.addStartingActor(getStewardess());
        dispatcher.addStartingActor(getPlanes());
    }
    public Patient getPatient(){
        if (patient == null){
            patient = new Patient("Patient",gui,this);
        }
        return patient;
    }   
    public Cashier getCashier(){
        if (cashier == null){
            cashier = new Cashier("Cashier",gui,this);
        }
        return cashier;
    }
    
        public Stewardess getStewardess(){
        if (stewardess == null){
            stewardess = new Stewardess("Stewardess",gui,this);
        }
        return stewardess;
    }
        
    public Plane getPlane(){
        if (plane == null){
            plane = new Plane("Plane",gui,this);
            //planes.setOriginal(plane);
            //planes.setNumberOfClones(gui.getChooseDataPlCount().getInt());
//          for (int i=0; i <  gui.getChooseDataPlCount().getInt();i++){
//        	queuePlain.addLast(new Object());
//          }
        }
        return plane;
    }
    
    public MultiActor getPlanes(){
        if (planes == null){
            //plane = new Plane("Plane",gui,this);
        	planes = new MultiActor();
            planes.setOriginal(getPlane());
            planes.setNumberOfClones(gui.getChooseDataPlCount().getInt());
//          for (int i=0; i <  gui.getChooseDataPlCount().getInt();i++){
//        	queuePlain.addLast(new Object());
//          }
        }
        return planes;
    }
    
    public QueueForTransactions getQueueToCashier() {
        if (this.queueToCashier == null) {
        	System.out.println("!");
            this.queueToCashier = new QueueForTransactions();
            this.queueToCashier.setNameForProtocol("Черга до кассира");
            this.queueToCashier.setDispatcher(this.dispatcher);
           // this.queueToCashier.setDiscretHisto(getHistoForQueueToCashier());
        }
        return this.queueToCashier;
    }
    
    
    public DiscretHisto getHistoForQueueToCashier()
     {
        if (this.histoForQueueToCashier == null) {
            this.histoForQueueToCashier = new DiscretHisto();
            this.histoForQueueToCashier.init();
        }
        return this.histoForQueueToCashier;
    }
    
    
    public QueueForTransactions getQueueToStewardess() {
        if (this.queueToStewardess == null) {
        	System.out.println("?");
            this.queueToStewardess = new QueueForTransactions();
            this.queueToStewardess.setNameForProtocol("Черга до стюардесси");
            this.queueToStewardess.setDispatcher(this.dispatcher);
         //   this.queueToStewardess.setDiscretHisto(getHistoForQueueToStewardess());
         }
        return this.queueToStewardess;
    }
        
        
    public DiscretHisto getHistoForQueueToStewardess()
    {
         if (this.histoForQueueToStewardess == null) {
            this.histoForQueueToStewardess = new DiscretHisto();
            this.histoForQueueToStewardess.init();
         }
         return this.histoForQueueToStewardess;
    }
        
    public QueueForTransactions getQueueToPlain() {
        if (this.queueToPlain == null) {
             this.queueToPlain = new QueueForTransactions();
             this.queueToPlain.setNameForProtocol("Черга до літака");
             this.queueToPlain.setDispatcher(this.dispatcher);
             this.queueToPlain.setDiscretHisto(getHistoForQueueToPlain());
        }
            return this.queueToPlain;
    }
            
            
    public DiscretHisto getHistoForQueueToPlain() {
        if (this.histoForQueueToPlain == null) {
              this.histoForQueueToPlain = new DiscretHisto();
              this.histoForQueueToPlain.init();
        }
        return this.histoForQueueToPlain;
    }
            
    public QueueForTransactions getQueuePlain() {
        if (this.queuePlain == null) {
            this.queuePlain = new QueueForTransactions();
            this.queuePlain.setNameForProtocol("Черга літаків");
            this.queuePlain.setDispatcher(this.dispatcher);
            this.queuePlain.setDiscretHisto(getHistoForQueuePlain());
        }
        return this.queuePlain;
    }
                
                
    public DiscretHisto getHistoForQueuePlain() {
        if (this.histoForQueuePlain == null) {
            this.histoForQueuePlain = new DiscretHisto();
            this.histoForQueuePlain.init();
        }
        return this.histoForQueuePlain;
    }
    public QueueForTransactions getQueuePass() {
        if (this.queuePass == null) {
                     this.queuePass = new QueueForTransactions();
                     this.queuePass.setNameForProtocol("Черга літаків");
                     this.queuePass.setDispatcher(this.dispatcher);
                     this.queuePass.setDiscretHisto(getHistoForQueuePass());
                     }
                    return this.queuePass;
                    }
                    
                    
         public DiscretHisto getHistoForQueuePass()
                     {
                     if (this.histoForQueuePass == null) {
                      this.histoForQueuePass = new DiscretHisto();
                      this.histoForQueuePass.init();
                     }
                     return this.histoForQueuePass;
                    }

         public void initForTest()
         {
              //getHeep().setPainter(this.gui.getDiagramHeepSize().getPainter());
              getQueueToCashier().setPainter(
            		  this.gui.getDiagram2().getPainter());
              getQueueToStewardess().setPainter(
            		  this.gui.getDiagram3().getPainter());
              getQueuePlain().setPainter(
            		  this.gui.getDiagram1().getPainter());
              getQueueToPlain().setPainter(
            		  this.gui.getDiagram4().getPainter());
              
         }
         
         public void initForStat()
         {
         this.dispatcher.setProtocolFileName("");
         }
         
}