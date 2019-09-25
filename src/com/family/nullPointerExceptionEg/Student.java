
package com.family.nullPointerExceptionEg;

/**
 * @author: gzb
 * @date  : 2019年8月1日 下午6:04:45
 *
 */
public class Student {
    
    Object name=null;
    
    int phone;

    /**
     * @return the name
     */
    public Object getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(Object name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
}
