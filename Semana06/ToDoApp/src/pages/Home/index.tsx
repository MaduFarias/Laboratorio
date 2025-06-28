import { useEffect, useState } from "react";
import "./style.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendar } from "@fortawesome/free-regular-svg-icons";
import { faSignal } from "@fortawesome/free-solid-svg-icons";
import { faWifi } from "@fortawesome/free-solid-svg-icons";
import { faBatteryFull } from "@fortawesome/free-solid-svg-icons";
import download from "../../assets/download.jfif";

function Home() {
  const [tarefa, setTarefa] = useState("");
  const [tarefas, setTarefas] = useState<string[]>([]);

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
    setTarefas([...tarefas, tarefa]);
    setTarefa("");
  };

  /*Remover tarefas*/
  const removerTarefa = (index: number) => {
    const novasTarefas = [...tarefas];
    novasTarefas.splice(index, 1);
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
                +
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
                  {t}
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
