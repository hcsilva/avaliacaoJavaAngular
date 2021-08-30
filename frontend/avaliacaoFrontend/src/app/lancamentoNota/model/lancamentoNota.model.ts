import { AnoBimestre } from './../../anoBimestre/model/anoBimestre.model';
import { Aluno } from './../../aluno/model/aluno.model';
export class LancamentoNota {
    id: number;
    aluno: Aluno;
    faltas: number;
    valorAvaliacao1: number;
    valorAvaliacao2: number;
    valorAvaliacao3: number;
    valorAvaliacao4: number;
    anoBimestre: AnoBimestre

    constructor(aluno: Aluno, faltas: number, valorAvaliacao1: number, valorAvaliacao2: number, valorAvaliacao3: number, valorAvaliacao4: number, anoBimestre: AnoBimestre) {
        this.aluno = aluno,
            this.faltas = faltas,
            this.valorAvaliacao1 = valorAvaliacao1,
            this.valorAvaliacao2 = valorAvaliacao2,
            this.valorAvaliacao3 = valorAvaliacao3,
            this.valorAvaliacao4 = valorAvaliacao4,
            this.anoBimestre = anoBimestre
    }
}