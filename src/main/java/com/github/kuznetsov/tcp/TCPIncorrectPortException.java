package com.github.kuznetsov.tcp;

import com.github.kuznetsov.range.OutOfRangeException;
import com.github.kuznetsov.range.Range;

/**
 *
 * @author leonid
 */
public class TCPIncorrectPortException extends OutOfRangeException{
    
    public TCPIncorrectPortException(int value) {
        super(TCPPort.PORT_RANGE, value, "Value " + value + " is out of available port range.");
    }
}
