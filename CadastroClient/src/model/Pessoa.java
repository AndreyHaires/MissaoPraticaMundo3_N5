// Importações omitidas para brevidade

@Entity
@Table(name = "Pessoa")
@NamedQueries({
    // NamedQueries omitidas para brevidade
})
public class Pessoa implements Serializable {

    // Atributos omitidos para brevidade

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaidPessoa")
    private Collection<PessoaJuridica> pessoaJuridicaCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaidPessoa")
    private Collection<PessoaFisica> pessoaFisicaCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaidPessoa")
    private Collection<Movimento> movimentoCollection;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nome, String email) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
    }

    // Métodos e getters/setters omitidos para brevidade

    /**
     * Obtém a coleção de PessoaJuridica relacionada a esta Pessoa.
     * 
     * @return A coleção de PessoaJuridica.
     */
    public Collection<PessoaJuridica> getPessoaJuridicaCollection() {
        return pessoaJuridicaCollection;
    }

    /**
     * Define a coleção de PessoaJuridica relacionada a esta Pessoa.
     * 
     * @param pessoaJuridicaCollection A coleção de PessoaJuridica.
     */
    public void setPessoaJuridicaCollection(Collection<PessoaJuridica> pessoaJuridicaCollection) {
        this.pessoaJuridicaCollection = pessoaJuridicaCollection;
    }

    /**
     * Obtém a coleção de PessoaFisica relacionada a esta Pessoa.
     * 
     * @return A coleção de PessoaFisica.
     */
    public Collection<PessoaFisica> getPessoaFisicaCollection() {
        return pessoaFisicaCollection;
    }

    /**
     * Define a coleção de PessoaFisica relacionada a esta Pessoa.
     * 
     * @param pessoaFisicaCollection A coleção de PessoaFisica.
     */
    public void setPessoaFisicaCollection(Collection<PessoaFisica> pessoaFisicaCollection) {
        this.pessoaFisicaCollection = pessoaFisicaCollection;
    }

    /**
     * Obtém a coleção de Movimento relacionada a esta Pessoa.
     * 
     * @return A coleção de Movimento.
     */
    public Collection<Movimento> getMovimentoCollection() {
        return movimentoCollection;
    }

    /**
     * Define a coleção de Movimento relacionada a esta Pessoa.
     * 
     * @param movimentoCollection A coleção de Movimento.
     */
    public void setMovimentoCollection(Collection<Movimento> movimentoCollection) {
        this.movimentoCollection = movimentoCollection;
    }

    // hashCode, equals e toString omitidos para brevidade
}
