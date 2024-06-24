function calculate() {
    const shelves = document.getElementById("shelves").value;
    const cells = document.getElementById("cellsForShelf").value;
    if (shelves && cells) {
        document.getElementById("capacity").value = shelves * cells;
    }
}