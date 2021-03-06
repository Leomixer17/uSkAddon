package net.leomixer17.askaddon.conditions;

import ch.njol.skript.lang.Condition;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

public class CondStringEndsWith extends Condition {

    private Expression<String> string;
    private Expression<String> stringendswith;
    private boolean b;

    @SuppressWarnings("unchecked")
    @Override
    public boolean init(Expression<?>[] exprs, int i, Kleenean arg2, ParseResult arg3)
    {
        this.string = (Expression<String>) exprs[0];
        this.stringendswith = (Expression<String>) exprs[1];
        this.b = i == 0;
        return true;
    }

    @Override
    public String toString(@Nullable Event e, boolean arg1)
    {
        return "string starts with another string";
    }

    @Override
    public boolean check(Event e)
    {
        if (this.b)
            return string.getSingle(e).endsWith(this.stringendswith.getSingle(e));
        return !string.getSingle(e).endsWith(this.stringendswith.getSingle(e));
    }

}
