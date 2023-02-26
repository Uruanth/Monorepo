public  enum Rol {
    ADMIN("ADMINISTRADOR"),
    OWNER("PROPIETARIO"),
    EMPLOYEE("EMPLOYEE"),
    CLIENT("CLIENTE");
    private final String tipo;

    Rol(String tipo) {
        this.tipo = tipo;
    }
}