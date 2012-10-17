package Modelrgr;

import process.Dispatcher;
import qusystem.IModelFactory;

public class Factory implements IModelFactory{
    public ModelGui gui;
    
    public Factory(ModelGui gui){
        this.gui = gui;
    }
    @Override
    public Model createModel(Dispatcher dispatcher) {
//        throw new UnsupportedOperationException("Not supported yet.");
        Model model = new Model(dispatcher,gui);
        return model;
    }  
}
