/* Warning: Automatically generated file */
package firm.nodes;

import com.sun.jna.Pointer;

public class Sync extends Node {

	public Sync(Pointer ptr) {
		super(ptr);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public static final int pnMax = 0;
}