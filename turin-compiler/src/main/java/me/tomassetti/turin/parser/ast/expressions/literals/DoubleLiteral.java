package me.tomassetti.turin.parser.ast.expressions.literals;

import com.google.common.collect.ImmutableList;
import me.tomassetti.turin.parser.ast.Node;
import me.tomassetti.turin.parser.ast.expressions.Expression;
import me.tomassetti.turin.typesystem.PrimitiveTypeUsage;
import me.tomassetti.turin.typesystem.TypeUsage;

public class DoubleLiteral extends Expression {

    private double value;

    public DoubleLiteral(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DoubleLiteral{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoubleLiteral that = (DoubleLiteral) o;

        if (value != that.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public Iterable<Node> getChildren() {
        return ImmutableList.of();
    }

    @Override
    public TypeUsage calcType() {
        return PrimitiveTypeUsage.DOUBLE;
    }

    public double getValue() {
        return value;
    }
}
