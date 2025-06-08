const apiUrl = 'http://localhost:8080/ocorrencias';

const listEl = document.getElementById('ocorrencias-list');
const searchInput = document.getElementById('search');
const searchBtn = document.getElementById('search-btn');

const createBtn = document.querySelector('.create-btn');
const popup = document.getElementById('popup');
const enviarBtn = document.getElementById('enviar-btn');
const fecharBtn = document.getElementById('fechar-btn');

async function fetchOcorrencias(idOcorrencia) {
  try {
    console.log(idOcorrencia);
    let response = null;

    if (idOcorrencia === undefined || idOcorrencia === '') {
      console.log('Vazio');
      response = await fetch(apiUrl, { method: "GET" });
      const data = await response.json();
      console.log(data);
      renderOcorrencias(data);
    } else {
      console.log('Com valor');
      response = await fetch(`${apiUrl}/${idOcorrencia}`, { method: "GET" });

      if (!response.ok) {
        throw new Error(`Erro ao buscar ocorrência com ID ${idOcorrencia}`);
      }

      const data = await response.json();
      console.log(data);
      renderOcorrencias([data]); // coloca em array para reusar mesma função
    }
  } catch (e) {
    listEl.innerHTML = '<p>Ocorreu um erro inesperado na busca</p>';
    console.error("Erro no fetch:", e);
  }
}

function renderOcorrencias(ocorrencias) {
  listEl.innerHTML = '';
  ocorrencias.forEach(o => {
    const card = document.createElement('div');
    card.className = 'ocorrencia';
    card.innerHTML = `
      <div><strong>ID:</strong> ${o.id} | <strong>Bairro:</strong> ${o.bairro}, ${o.rua} | <strong>${o.dataHora}</strong> | <strong>${o.curtidas}</strong> Likes</div>
      <h3>${o.cidade}</h3>
      <p>${o.descricao}</p>
      <span class="status">${o.statusConcluido}</span>
      <button class="like-btn">Curtir</button>
      <button class="status-btn">Trocar Status</button>
    `;

    const likeBtn = card.querySelector('.like-btn');
    likeBtn.addEventListener('click', async () => {
      await fetch(`${apiUrl}/${o.id}/curtir`, {
        method: 'PATCH',
        headers: { 'Content-Type': 'application/json' },
      });
      fetchOcorrencias('');
    });

    const statusBtn = card.querySelector('.status-btn');
    statusBtn.addEventListener('click', async () => {
      console.log('chegou');
      await fetch(`${apiUrl}/${o.id}/concluir`, {
        method: 'PATCH',
        headers: { 'Content-Type': 'application/json' },
      });
      fetchOcorrencias('');
    });

    listEl.appendChild(card);
  });
}

searchBtn.addEventListener('click', () => {
  fetchOcorrencias(searchInput.value);
});

createBtn.addEventListener('click', () => {
  popup.classList.remove('hidden');
});

fecharBtn.addEventListener('click', () => {
  popup.classList.add('hidden');
});

enviarBtn.addEventListener('click', async () => {
  const cidade = document.getElementById('cidade').value;
  const bairro = document.getElementById('bairro').value;
  const rua = document.getElementById('rua').value;
  const numero = document.getElementById('numero').value;
  const descricao = document.getElementById('descricao').value;

  const novaOcorrencia = {
    cidade,
    bairro,
    rua,
    numero,
    descricao
  };

  await fetch(apiUrl, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(novaOcorrencia)
  });

  popup.classList.add('hidden');
  fetchOcorrencias();
});

fetchOcorrencias();
