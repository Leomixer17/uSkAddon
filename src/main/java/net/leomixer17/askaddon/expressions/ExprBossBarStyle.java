package net.leomixer17.askaddon.expressions;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.classes.Changer.ChangeMode;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.util.coll.CollectionUtils;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.event.Event;

public class ExprBossBarStyle extends SimplePropertyExpression<BossBar, BarStyle> {

    public BarStyle convert(BossBar bar)
    {
        if (bar == null)
            return null;
        return bar.getStyle();
    }

    public void change(Event e, Object[] delta, ChangeMode mode)
    {
        BossBar bar = (BossBar) getExpr().getSingle(e);
        if (bar == null)
            return;
        BarStyle b = (BarStyle) delta[0];
        if (mode == Changer.ChangeMode.SET)
            bar.setStyle(b);
    }

    public Class<?>[] acceptChange(ChangeMode mode)
    {
        if (mode == Changer.ChangeMode.SET)
            return (Class[]) CollectionUtils.array(new Class[]{
                    BarStyle.class
            });
        return null;
    }

    public Class<? extends BarStyle> getReturnType()
    {
        return BarStyle.class;
    }

    protected String getPropertyName()
    {
        return "style of boss bar";
    }

}