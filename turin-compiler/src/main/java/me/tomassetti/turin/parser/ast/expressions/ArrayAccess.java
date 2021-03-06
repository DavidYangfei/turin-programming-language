package me.tomassetti.turin.parser.ast.expressions;

import com.google.common.collect.ImmutableList;
import me.tomassetti.turin.parser.ast.Node;
import me.tomassetti.turin.typesystem.TypeUsage;

public class ArrayAccess extends Expression {

    private Expression array;
    private Expression index;

    public Expression getArray() {
        return array;
    }

    public Expression getIndex() {
        return index;
    }

    public ArrayAccess(Expression array, Expression index) {
        this.array = array;
        this.array.setParent(this);
        this.index = index;

        this.index.setParent(this);
    }

    @Override
    public Iterable<Node> getChildren() {
        return ImmutableList.of(array, index);
    }

    @Override
    public TypeUsage calcType() {
        TypeUsage arrayType = array.calcType();
        if (arrayType.isArray()) {
            return arrayType.asArrayTypeUsage().getComponentType();
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
