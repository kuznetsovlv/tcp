package com.github.kuznetsov.tcp;

import com.github.kuznetsov.range.Range;

/**
 *
 * @author leonid
 */
public class TCPPort {
    public static final Range PORT_RANGE = new Range(0, 65535);
    public static final Range SYSTEM_PORTS = new Range(0, 1023);
    public static final Range REGISTERED_PORTS = new Range(1024, 49151);
    public static final Range DYNAMIC_PORTS = new Range(49151, 65535);
    
    private final int value;

    public TCPPort(int value) throws TCPIncorrectPortException {
        if (PORT_RANGE.inRange(value)) {
            this.value = value;
        } else {
            throw new TCPIncorrectPortException(value);
        }
    }
    
    public int value() {
        return value;
    }
    
    public boolean isSystem() {
        return SYSTEM_PORTS.inRange(value);
    }
    
    public boolean isFree() {
        return !isSystem();
    }
    
    public boolean isRegistered() {
        return REGISTERED_PORTS.inRange(value);
    }
    
    public boolean isDynamic() {
        return DYNAMIC_PORTS.inRange(value);
    }
}
