package org.uengine.uml.model;

import org.metaworks.MetaworksContext;
import org.metaworks.ServiceMethodContext;
import org.metaworks.WebFieldDescriptor;
import org.metaworks.WebObjectType;
import org.metaworks.annotation.Face;
import org.metaworks.annotation.Hidden;
import org.metaworks.annotation.Order;
import org.metaworks.annotation.ServiceMethod;
import org.metaworks.widget.ModalWindow;
import org.uengine.uml.model.face.AttributeListFace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.metaworks.dwr.MetaworksRemoteService.metaworksCall;
import static org.metaworks.dwr.MetaworksRemoteService.wrapReturn;

public class ClassDefinition extends WebObjectType implements Serializable{

    //List<Attribute> attributeList = new ArrayList<Attribute>();
//    @Face(faceClass = AttributeListFace.class)
//        public List<Attribute> getAttributeList() {
//            return attributeList;
//        }
//        public void setAttributeList(List<Attribute> attributeList) {
//            this.attributeList = attributeList;
//        }



    @Override
    @Face(faceClass = AttributeListFace.class, displayName = "$fields")
    public Attribute[] getFieldDescriptors() {
        return (Attribute[]) super.getFieldDescriptors();
    }

//    public void setFieldDescriptors(Attribute[] fieldDescriptors) {
//        super.setFieldDescriptors(fieldDescriptors);
//    }

    @ServiceMethod(callByContent = true, target= ServiceMethodContext.TARGET_POPUP)
    public ObjectInstance createObjectInstance() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ObjectInstance objectInstance = newObjectInstance();
        objectInstance.setMetaworksContext(new MetaworksContext());
        objectInstance.getMetaworksContext().setWhen(MetaworksContext.WHEN_EDIT);

        objectInstance.setClassDefinition(this);

//        for(Attribute attribute : getAttributeList()){
//            objectInstance.getAttributeInstanceList().add(attribute.createInstance());
//
//        }

        if(metaworksCall()) wrapReturn(new ModalWindow(objectInstance));

        return objectInstance;
    }

    protected ObjectInstance newObjectInstance() {
        return new ObjectInstance();
    }



    ///// -- ordering ---

    @Override
    @Order(1)
    public String getName() {
        return super.getName();
    }

    @Override
    @Order(2)
    public String getDisplayName() {
        return super.getDisplayName();
    }


    ////// ---- hidden fields ------


    @Override
    @Hidden
    public boolean isDesignable() {
        return super.isDesignable();
    }

    @Override
    @Hidden
    public List<String> getSuperClasses() {
        return super.getSuperClasses();
    }

    @Override
    @Hidden
    public String[] getFaceMappingByContext() {
        return super.getFaceMappingByContext();
    }

    @Override
    @Hidden
    public String getFaceComponentPath() {
        return super.getFaceComponentPath();
    }

    @Override
    @Hidden
    public String getFaceForArray() {
        return super.getFaceForArray();
    }

    @Override
    @Hidden
    public Map<String, String> getFaceOptions() {
        return super.getFaceOptions();
    }

    @Override
    @Hidden
    public Map<String, HashMap> getAutowiredFields() {
        return super.getAutowiredFields();
    }

    @Override
    @Hidden
    public Map<String, String> getOnDropTypes() {
        return super.getOnDropTypes();
    }

    @Override
    @Hidden
    public WebFieldDescriptor getKeyFieldDescriptor() {
        return super.getKeyFieldDescriptor();
    }


    @Override
    @Hidden
    public boolean isInterface() {
        return super.isInterface();
    }

    @Override
    @Hidden
    public List<ServiceMethodContext> getServiceMethodContexts() {
        return super.getServiceMethodContexts();
    }
}
