// Fade-in suave nos elementos ao carregar a página
document.addEventListener("DOMContentLoaded", () => {
    const rows = document.querySelectorAll("table tr");
    rows.forEach((row, i) => {
        row.style.opacity = 0;
        row.style.transition = `opacity 0.5s ease ${(i + 1) * 100}ms`;
        setTimeout(() => {
            row.style.opacity = 1;
        }, 100);
    });

    // Botão que balança quando o mouse passa
    const button = document.querySelector("button");
    if (button) {
        button.addEventListener("mouseover", () => {
            button.classList.add("wiggle");
        });
        button.addEventListener("animationend", () => {
            button.classList.remove("wiggle");
        });
    }
});
