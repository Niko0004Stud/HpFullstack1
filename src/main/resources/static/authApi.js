const base_URL = "/auth";

export async function verifyLogin(formData){
    const response = await fetch(`${base_URL}/login`,{
        method: "POST",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify(formData)
    });

    if(!response.ok) {
        const error = await response.json();
        throw new Error(error.detail);
    }
    return await response.json();
}