package org.jesperancinha.jtd.jee.app2.adapter;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;

public class KitchenHerbsConnectionFactoryImpl implements KitchenHerbsConnectionFactory {
    private static final long serialVersionUID = 1L;

    private Reference reference;

    private KitchenHerbsManagedConnectionFactory mcf;
    private ConnectionManager connectionManager;

    public KitchenHerbsConnectionFactoryImpl(KitchenHerbsManagedConnectionFactory mcf, ConnectionManager cxManager) {
        this.mcf = mcf;
        this.connectionManager = cxManager;
    }

    @Override
    public KitchenHerbsConnection getConnection() throws ResourceException {
        return (KitchenHerbsConnection) connectionManager.allocateConnection(mcf, null);
    }

    @Override
    public Reference getReference() throws NamingException {
        return reference;
    }

    @Override
    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public String toString() {
        Consolerizer.setupFastDefault();
        Consolerizer.printUnicornsLn(100);
        Consolerizer.printOrangeGenericLn(
                "This instance is of a different type because it is being loaded in a different module");
        Consolerizer.printOrangeGenericLn("We are not going to fix this in this module.");
        Consolerizer.printOrangeGenericLn(
                "This module is here just to give an idea on how different modules can work together");
        Consolerizer.printOrangeGenericLn(
                "Using @Resource, we were able to inject an instance from a different module into our own");
        Consolerizer.printOrangeGenericLn("We did this, by using JNDI technology");
        Consolerizer.printOrangeGenericLn("JNDI stads for Java Naming and Directory Interface");
        Consolerizer.printOrangeGenericLn(
                "Our Java Connector API resource is discoverable with the use of the Referenceable interface");
        Consolerizer.printOrangeGenericLn("We haven't seen the connector in action in this case.");
        Consolerizer.printUnicornsLn(100);
        return KitchenHerbsConnectionFactoryImpl.class.toString();
    }
}