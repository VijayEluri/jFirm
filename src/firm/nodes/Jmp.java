/* Warning: Automatically generated file */
package firm.nodes;

import com.sun.jna.Pointer;

public class Jmp extends Node {

	public Jmp(Pointer ptr) {
		super(ptr);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public static final int pnMax = 0;
}