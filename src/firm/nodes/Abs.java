/* Warning: Automatically generated file */
package firm.nodes;

import com.sun.jna.Pointer;

public class Abs extends Unop {

	public Abs(Pointer ptr) {
		super(ptr);
	}

	
	public Node getOp() {
		return createWrapper(binding.get_Abs_op(ptr));
	}

	public void setOp(Node op) {
		binding.set_Abs_op(this.ptr, op.ptr);
	}
	

	

	

	
}