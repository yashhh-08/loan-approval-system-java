const form = document.getElementById("loanForm");
const resultCard = document.getElementById("resultCard");

form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const formData = new FormData(form);
    const searchParams = new URLSearchParams(formData);

    try {
        const response = await fetch("http://localhost:8080/loan", {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: searchParams.toString()
        });

        if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);

        const result = await response.text();
        resultCard.innerText = result;
    } catch (err) {
        resultCard.innerText = `⚠️ Error connecting to server: ${err.message}`;
    }
});
