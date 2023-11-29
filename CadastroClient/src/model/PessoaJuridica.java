// Importações omitidas para brevidade

/**
 * Representa uma Pessoa Jurídica no sistema.
 */
@Entity
@Table(name = "PessoaJuridica")
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT p FROM PessoaJuridica p"),
    @NamedQuery(name = "PessoaJuridica.findByCnpj", query = "SELECT p FROM PessoaJuridica p WHERE p.cnpj = :cnpj")
})
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "cnpj")
    private String cnpj;

    @JoinColumn(name = "Pessoa_idPessoa", referencedColumnName = "idPessoa")
    @ManyToOne(optional = false)
    private Pessoa pessoa;

    public PessoaJuridica() {
    }

    /**
     * Construtor que recebe o CNPJ da Pessoa Jurídica.
     *
     * @param cnpj O CNPJ da Pessoa Jurídica.
     */
    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * Obtém o CNPJ da Pessoa Jurídica.
     *
     * @return O CNPJ da Pessoa Jurídica.
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o CNPJ da Pessoa Jurídica.
     *
     * @param cnpj O CNPJ a ser definido.
     */
    public void setCnpj(String cnpj) {
        // Adicione validações de CNPJ aqui, se necessário
        this.cnpj = cnpj;
    }

    /**
     * Obtém a Pessoa associada a esta Pessoa Jurídica.
     *
     * @return A Pessoa associada.
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * Define a Pessoa associada a esta Pessoa Jurídica.
     *
     * @param pessoa A Pessoa a ser definida.
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnpj != null ? cnpj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        return !((this.cnpj == null && other.cnpj != null) || (this.cnpj != null && !this.cnpj.equals(other.cnpj)));
    }

    @Override
    public String toString() {
        return "model.PessoaJuridica[ cnpj=" + cnpj + " ]";
    }
}
