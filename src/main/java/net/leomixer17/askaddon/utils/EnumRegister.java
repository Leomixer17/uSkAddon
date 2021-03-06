package net.leomixer17.askaddon.utils;

public final class EnumRegister {

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <E> void registerEnum(Class cls, String codeName)
    {
        EnumClassInfo.create(cls, codeName).register();
    }

}
