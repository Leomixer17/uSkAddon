package net.leomixer17.askaddon.expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.google.gson.Gson;
import org.bukkit.boss.BossBar;
import org.bukkit.event.Event;

public class ExprSerialiseBossBar extends SimpleExpression<String> {

    private Expression<BossBar> bar;

    protected String[] get(Event event)
    {
        Gson gson = new Gson();
        String returnStr = gson.toJson(this.bar.getSingle(event));
        return new String[]{
                returnStr
        };
    }

    public boolean isSingle()
    {
        return true;
    }

    public Class<? extends String> getReturnType()
    {
        return String.class;
    }

    public String toString(Event event, boolean b)
    {
        return "serialise boss bar";
    }

    @SuppressWarnings("unchecked")
    public boolean init(Expression<?>[] exprs, int i, Kleenean kleenean, ParseResult parseResult)
    {
        this.bar = (Expression<BossBar>) exprs[0];
        return true;
    }

}