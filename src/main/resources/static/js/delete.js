const deleteModal = document.getElementById("deleteModal");
deleteModal.addEventListener("show.bs.modal", (event) => {
  const button = event.relatedTarget;
  const id = button.getAttribute("data-id");
  const form = deleteModal.querySelector("#deleteForm");
  form.setAttribute("action", `/eliminar/${id}`);
});
