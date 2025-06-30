import { useEffect, useState } from "react";
import "./style.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendar } from "@fortawesome/free-regular-svg-icons";
import { faSignal } from "@fortawesome/free-solid-svg-icons";
import { faWifi } from "@fortawesome/free-solid-svg-icons";
import { faBatteryFull } from "@fortawesome/free-solid-svg-icons";
import { faPlus } from "@fortawesome/free-solid-svg-icons";
import { faCheck } from "@fortawesome/free-solid-svg-icons";
import download from "../../assets/download.jfif";

function Home() {
  const [tarefa, setTarefa] = useState("");
  const [tarefas, setTarefas] = useState<{ texto: string; checked: boolean }[]>(
    []
  );

  /* Carregar dados Storage */
  useEffect(() => {
    const tarefasSalvas = localStorage.getItem("tarefas");
    if (tarefasSalvas) {
      setTarefas(JSON.parse(tarefasSalvas));
    }
  }, []);

  /*Salvar no Storage toda vez que os dados mudarem*/
  useEffect(() => {
    localStorage.setItem("tarefas", JSON.stringify(tarefas));
  }, [tarefas]);

  /*adicionar nova tarefa*/
  const adicionarTarefa = () => {
    if (tarefa.trim() === "") return;
    setTarefas([...tarefas, { texto: tarefa, checked: false }]);
    setTarefa("");
  };

  /*Remover tarefas*/
  const removerTarefa = (index: number) => {
    const novasTarefas = [...tarefas];
    novasTarefas.splice(index, 1);
    setTarefas(novasTarefas);
  };

  const alternarCheck = (index: number) => {
    const novasTarefas = [...tarefas];
    novasTarefas[index].checked = !novasTarefas[index].checked;
    setTarefas(novasTarefas);
  };

  return (
    <>
      <div className="background">
        <div className="area-celular">
          <div className="area-navegacao">
            <div className="navegacao-elementos">
              <p className="horario">9:10</p>
              <div className="icones">
                <FontAwesomeIcon icon={faSignal} />
                <FontAwesomeIcon icon={faWifi} />
                <FontAwesomeIcon icon={faBatteryFull} />
              </div>
            </div>
          </div>
          <div className="area-usuario">
            <img src={download} alt="perfil" className="imagem-perfil" />
            <h2>MADU FARIAS</h2>
          </div>
          <div className="area-botaoData">
            <FontAwesomeIcon icon={faCalendar} size="xl" color="#555" />
          </div>
          <div className="area-tarefas">
            <div className="area-novaTarefa">
              <button className="botaoCriar" onClick={adicionarTarefa}>
                <FontAwesomeIcon icon={faPlus} />
              </button>
              <input
                type="text"
                placeholder="Nova tarefa"
                value={tarefa}
                onChange={(e) => setTarefa(e.target.value)}
              />
            </div>
            <ul className="lista-tarefas">
              {tarefas.map((t, i) => (
                <li className="tarefa" key={i}>
                  <div className="checkEtexto">
                    <div
                      className="area-botaoCheck"
                      onClick={() => alternarCheck(i)}
                    >
                      {t.checked ? (
                        <FontAwesomeIcon
                          icon={faCheck}
                          className="iconeCheck"
                        />
                      ) : (
                        <div className="circuloVazio" />
                      )}
                    </div>
                    <span className="textoTarefa">{t.texto}</span>
                  </div>
                  <button className="botaoX" onClick={() => removerTarefa(i)}>
                    x
                  </button>
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    </>
  );
}

export default Home;
