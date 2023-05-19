package entidades;

public class Usuario {
    private int id_usuario;
    private String nombres;
    private String apellidos;
    private int edad;
    private String TipoDocumento;
    private String NumDocumento;
    private String Celular;
    private String correo;
    private int id_perfil;


    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", edad=" + edad +
                ", TipoDocumento='" + TipoDocumento + '\'' +
                ", NumDocumento='" + NumDocumento + '\'' +
                ", Celular='" + Celular + '\'' +
                ", correo='" + correo + '\'' +
                ", id_perfil=" + id_perfil +
                '}';
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return NumDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        NumDocumento = numDocumento;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
}
