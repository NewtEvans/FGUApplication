const API_URL = "http://localhost:8081";

export async function apiGet(url) {
  const apiUrl = `${API_URL}${url}`;
  try {
    const response = await fetch(apiUrl);

    if (!response.ok) {
      throw new Error(
        `API request failed: ${response.status} ${response.statusText}`
      );
    }
    return await response.json();
  } catch (error) {
    console.error("Error fetching data:", error);
    throw error;
  }
}
