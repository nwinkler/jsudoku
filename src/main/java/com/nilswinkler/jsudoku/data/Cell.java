package com.nilswinkler.jsudoku.data;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Cell {
	private int number;
	private boolean fixed;
    private Set listeners = new HashSet();
	
	public Cell(int number, boolean fixed) {
		this.number = number;
		this.fixed = fixed;
	}

	public Cell() {
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		if (fixed) {
			throw new IllegalArgumentException("Can't set number for fixed cells.");
		}
		
		this.number = number;
	}
	
	public boolean isFixed() {
		return fixed;
	}

	public void setFixed(boolean fixed) {
		this.fixed = fixed;
	}

    /**
     * @see java.lang.Object#equals(Object)
     */
    public boolean equals(Object object) {
        if (!(object instanceof Cell)) {
            return false;
        }
        Cell rhs = (Cell) object;
        return new EqualsBuilder().append(this.fixed, rhs.fixed).append(
                this.number, rhs.number).isEquals();
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return new HashCodeBuilder(-2081240831, -953508283).append(this.fixed)
                .append(this.number).toHashCode();
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return new ToStringBuilder(this).append("number", this.number).append(
                "fixed", this.fixed).toString();
    }
    
    public void addCellListener(CellListener listener) {
        listeners.add(listener);
    }
    
    public void removeCellListener(CellListener listener) {
        listeners.remove(listener);
    }
}
