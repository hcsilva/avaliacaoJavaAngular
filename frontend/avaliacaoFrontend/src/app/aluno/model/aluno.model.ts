export class Aluno {
    id: number;
    nome: string;
    situacao: string;


    constructor(nome: string, situacao: string) {
        this.nome = nome,
        this.situacao = situacao
    }
}