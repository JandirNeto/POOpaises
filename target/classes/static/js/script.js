document.addEventListener("DOMContentLoaded", () => {
    // Fade-in suave nos cards ao carregar a página
    const cards = document.querySelectorAll(".pais-card");
    cards.forEach((card, i) => {
        card.style.opacity = 0;
        card.style.transition = `opacity 0.6s ease ${(i + 1) * 100}ms, transform 0.6s ease ${(i + 1) * 100}ms`;
        setTimeout(() => {
            card.style.opacity = 1;
            card.style.transform = 'translateY(0)';
        }, 50);
    });

    // Animação inicial dos cards
    cards.forEach(card => {
        card.style.transform = 'translateY(20px)';
    });

    // Botão que balança quando o mouse passa (aplicado a todos os botões .btn)
    const buttons = document.querySelectorAll(".btn");
    buttons.forEach(button => {
        button.addEventListener("mouseover", () => {
            button.classList.add("wiggle");
        });
        button.addEventListener("animationend", () => {
            button.classList.remove("wiggle");
        });
    });

    // --- Lógica do Modal de Filtro ---
    const filterModal = document.getElementById('filterModal');
    const openFilterModalBtn = document.getElementById('openFilterModal');
    const closeButton = document.querySelector('.close-button');
    const filterFormModal = document.getElementById('filterFormModal');

    if (openFilterModalBtn) {
        openFilterModalBtn.addEventListener('click', () => {
            filterModal.style.display = 'flex'; // Usar flex para centralizar
        });
    }

    if (closeButton) {
        closeButton.addEventListener('click', () => {
            filterModal.style.display = 'none';
        });
    }

    // Fechar modal clicando fora do conteúdo
    if (filterModal) {
        window.addEventListener('click', (event) => {
            if (event.target == filterModal) {
                filterModal.style.display = 'none';
            }
        });
    }
});