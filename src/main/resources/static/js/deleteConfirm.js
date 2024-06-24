const deleteBtn = document.getElementById("btnHidden");
const pressBtn = document.getElementById("btnPressed");
pressBtn.addEventListener("click", () => {
    const result = confirm("Подтвердите удаление, будут удалены все связанные объекты");
    if (result===true) {
        deleteBtn.click();
    }
});