package firm;

import com.sun.jna.Pointer;

import firm.bindings.binding_typerep;
import firm.bindings.binding_typerep.ir_type_state;

public class Type extends JNAWrapper {
	
	protected static final binding_typerep binding = Entity.binding;
	
	protected Type(Pointer ptr) {
		super(ptr);
	}
	
	public static Type createWrapper(Pointer ptr) {
		if (binding.is_Primitive_type(ptr) != 0) {
			return new PrimitiveType(ptr);
		} else if (binding.is_Method_type(ptr) != 0) {
			return new MethodType(ptr);
		} else if (binding.is_Array_type(ptr) != 0) {
			return new ArrayType(ptr);
		} else if (binding.is_Class_type(ptr) != 0) {
			return new ClassType(ptr);
		} else {
			/* TODO: add missing types */
			return new Type(ptr);
		}
	}
	
	public void setSizeBytes(int size) {
		binding.set_type_size_bytes(ptr, size);
	}
	
	public int getSizeBytes() {
		return binding.get_type_size_bytes(ptr);
	}
	
	public void setAlignmentBytes(int alignment) {
		binding.set_type_alignment_bytes(ptr, alignment);
	}
	
	public int getAlignmentBytes() {
		return binding.get_type_alignment_bytes(ptr);
	}
	
	public void setTypeState(binding_typerep.ir_type_state state) {
		binding.set_type_state(ptr, state.val);
	}
	
	public binding_typerep.ir_type_state getTypeState() {
		return ir_type_state.getEnum(binding.get_type_state(ptr));
	}
	
	public Ident getIdent() {
		return new Ident(binding.get_type_ident(ptr));
	}
	
	public String getName() {
		return binding.get_type_name(ptr);
	}
	
	public String toString() {
		return getName();
	}
	
	/** returns the mode of a type (or null for non-atomic types) */
	public Mode getMode() {
		Pointer mode_ptr = binding.get_type_mode(ptr);
		if (mode_ptr.equals(Pointer.NULL))
			return null;
		return new Mode(mode_ptr);
	}

	/** you must call this function when you are finished constructing a type */
	public void fixed() {
		setTypeState(ir_type_state.layout_fixed);
	}
}
