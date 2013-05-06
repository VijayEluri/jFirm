/* Warning: Automatically generated file */
package firm.nodes;

import com.sun.jna.Pointer;
import firm.bindings.binding_irop;

public class Free extends Node {
	static class Factory implements NodeWrapperFactory {
		@Override
		public Node createWrapper(Pointer ptr) {
			return new Free(ptr);
		}
	}

	static void init() {
		Pointer op = firm.bindings.binding_irnode.get_op_Free();
		Node.registerFactory(binding_irop.get_op_code(op), new Factory());
	}

	public Free(Pointer ptr) {
		super(ptr);
	}

	public Node getMem() {
		return createWrapper(firm.bindings.binding_irnode.get_Free_mem(ptr));
	}

	public void setMem(Node mem) {
		firm.bindings.binding_irnode.set_Free_mem(this.ptr, mem.ptr);
	}

	public Node getPtr() {
		return createWrapper(firm.bindings.binding_irnode.get_Free_ptr(ptr));
	}

	public void setPtr(Node ptr) {
		firm.bindings.binding_irnode.set_Free_ptr(this.ptr, ptr.ptr);
	}

	public Node getCount() {
		return createWrapper(firm.bindings.binding_irnode.get_Free_count(ptr));
	}

	public void setCount(Node count) {
		firm.bindings.binding_irnode.set_Free_count(this.ptr, count.ptr);
	}

	public firm.Type getType() {
		Pointer _res = firm.bindings.binding_irnode.get_Free_type(ptr);
		return firm.Type.createWrapper(_res);
	}

	public void setType(firm.Type _val) {
		firm.bindings.binding_irnode.set_Free_type(this.ptr, _val.ptr);
	}

	public firm.bindings.binding_ircons.ir_where_alloc getWhere() {
		int _res = firm.bindings.binding_irnode.get_Free_where(ptr);
		return firm.bindings.binding_ircons.ir_where_alloc.getEnum(_res);
	}

	public void setWhere(firm.bindings.binding_ircons.ir_where_alloc _val) {
		firm.bindings.binding_irnode.set_Free_where(this.ptr, _val.val);
	}

	@Override
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public static final int pnMax = 0;
}
