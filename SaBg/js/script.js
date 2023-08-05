const sidebar = document.querySelector(".side-bar");
const danhmucButton = document.querySelector(".danhmuc");
danhmucButton.addEventListener("click", () => {
  sidebar.classList.toggle("sidebar-open");
  danhmucButton.classList.toggle("bg-yellow");
});
