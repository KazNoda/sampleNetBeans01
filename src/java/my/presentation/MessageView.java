/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import entities.HelloMessage;
import boundary.HelloMessageFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author takeken
 */
@ManagedBean
@RequestScoped
public class MessageView {
    
    @EJB
    HelloMessageFacade helloMessageFacade;
    
    private HelloMessage message;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message = new HelloMessage();
    }
    
    public HelloMessage getMessage() {
        return message;
    }
    
    public int getNumberOfMessages() {
        return helloMessageFacade.findAll().size();
    }
    
    public String save() {
        this.helloMessageFacade.create(message);
        return "theend";
    }
}
